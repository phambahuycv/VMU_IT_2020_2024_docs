import sys
# pip install pyqt5
from PyQt5.QtWidgets import QApplication, QMainWindow, QFileDialog
from giaodienbtlXLA import Ui_MainWindow
from PyQt5.QtGui import QPixmap
import matplotlib.pyplot as plt
from keras.models import load_model  # TensorFlow is required for Keras to work
from PIL import Image, ImageOps  # Install pillow instead of PIL
import numpy as np
import cv2
import os
import glob
from PyQt5.QtCore import QUrl
from PyQt5.QtMultimedia import QMediaPlayer, QMediaContent
from PyQt5.QtMultimediaWidgets import QVideoWidget
class MainWindow:
    def __init__(self):
        self.main_win = QMainWindow()
        self.uic = Ui_MainWindow()
        self.uic.setupUi(self.main_win)
        self.uic.selectImage.clicked.connect(self.linkto)
        # self.uic.selectVideo.clicked.connect(self.linkto2)
        self.uic.btnRun.clicked.connect(self.xuly)
        
        # self.uic.btnRun.clicked.connect(self.check_img)
        self.link_anh = ''
        # self.link_video = ''
    def linkto(self):
        #         tim duong dan
        link = QFileDialog.getOpenFileName(filter='*.jpg')
        #         mo hinh len
        self.uic.inputImage.setPixmap(QPixmap(link[0]))
        self.link_anh = link[0]
    # def linkto2(self):        
    #     link2 = QFileDialog.getOpenFileName(filter='*.mkv')
    #     self.mediaPlayer = QMediaPlayer(None, QMediaPlayer.VideoSurface)
    #     self.mediaPlayer.setMedia(QMediaContent(QUrl.fromLocalFile(link2[0])))
    #     self.link_video = link2[0]       
    #     self.mediaPlayer.play() 
    def xuly(self):
        np.set_printoptions(suppress=True)
        model = load_model("keras_Model.h5", compile=False)
        # Load the labels
        class_names = open("labels.txt", "r").readlines()
        data = np.ndarray(shape=(1, 224, 224, 3), dtype=np.float32)
        image = Image.open(self.link_anh).convert("RGB")
        # resizing the image to be at least 224x224 and then cropping from the center
        size = (224, 224)
        image = ImageOps.fit(image, size, Image.Resampling.LANCZOS)
        # turn the image into a numpy array
        image_array = np.asarray(image)
        # Normalize the image
        normalized_image_array = (image_array.astype(np.float32) / 127.5) - 1
        # Load the image into the array
        data[0] = normalized_image_array
        # Predicts the model
        prediction = model.predict(data)
        index = np.argmax(prediction)
        class_name = class_names[index]
        confidence_score = prediction[0][index]
        # Print prediction and confidence score
        print("Cờ của nước:", class_name[3:], end="")
        #print("Confidence Score:", confidence_score)
        s= class_name
        lst = s.split()
        result = lst[-1]
        image_dir = 'C:\\code\python\\flag\\'+ result + '.jpg'
        print(image_dir)
        self.uic.outputImage.setPixmap(QPixmap(image_dir))
        self.link_anh = image_dir      
    def show(self):
        self.main_win.show()
if __name__ == "__main__":
    app = QApplication(sys.argv)
    main_win = MainWindow()
    main_win.show()
    sys.exit(app.exec())