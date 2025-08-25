# -*- coding: utf-8 -*-
"""
Created on Tue Mar 21 19:18:19 2023

@author: Pham Ba Huy
"""

from keras.models import load_model  # TensorFlow is required for Keras to work
from PIL import Image, ImageOps  # Install pillow instead of PIL
import numpy as np
import cv2
import os
import glob

#tắt hiển thị dạng số mũ cho các giá trị số trong mảng numpy khi in ra màn hình.
# Các giá trị số trong mảng numpy có thể rất nhỏ hoặc rất lớn,
# dẫn đến hiển thị dưới dạng số mũ có thể làm cho việc đọc và hiểu kết quả trở nên khó khăn. 
#Việc sử dụng lệnh này sẽ giúp cho kết quả được hiển thị dưới dạng số thập phân thay vì dạng số mũ,
# giúp cho việc đọc và hiểu kết quả trở nên dễ dàng hơn.
np.set_printoptions(suppress=True)

# Load the model
model = load_model("keras_Model.h5", compile=False)

# Load the labels
class_names = open("labels.txt", "r").readlines()

# Create the array of the right shape to feed into the keras model
#(1 anh, kich thuoc mo hinh huan luyen, anh mau RGB)
# determined by the first position in the shape tuple, in this case 1
data = np.ndarray(shape=(1, 224, 224, 3), dtype=np.float32)

# Replace this with the path to your image

image = Image.open(r".\input\221.jpg").convert("RGB")

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
image_dir = 'flag/'
image_paths = glob.glob(os.path.join(image_dir, '*.jpg'))
for path in image_paths:
    if os.path.basename(path) == result+'.jpg':
        print(result)
        img= cv2.imread('flag/'+result+'.jpg')
        cv2.imshow("Flag:",img)
        cv2.waitKey()
        break
else:
    print(' ')