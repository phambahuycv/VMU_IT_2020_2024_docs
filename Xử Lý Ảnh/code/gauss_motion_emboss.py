# -*- coding: utf-8 -*-
"""
Created on Sun Mar  5 19:52:44 2023

@author: Pham Ba Huy
"""

import cv2
import os
import glob
import numpy as np

kernel = np.zeros((5,5),np.float32)
kernel[0][0] = 1.0/5
kernel[1][1] = 1.0/5
kernel[2][2] = 1.0/5
kernel[3][3] = 1.0/5
kernel[4][4] = 1.0/5

emboss_k = np.ones((5,5),np.float32)
emboss_k[0][0] = -1
emboss_k[0][1] = -1
emboss_k[0][2] = -1
emboss_k[0][3] = -1
emboss_k[1][0] = -1
emboss_k[1][1] = -1
emboss_k[1][2] = -1
emboss_k[2][0] = -1
emboss_k[2][1] = -1
emboss_k[3][0] = -1
emboss_k[4][0] = 0
emboss_k[3][1] = 0
emboss_k[2][2] = 0
emboss_k[1][3] = 0
emboss_k[0][4] = 0

in_folder = r'C:\code/*.jpg'
out_folder = './output/'
idx = 0
for img_path in glob.glob(in_folder):
    img = cv2.imread(img_path)
    motion = cv2.filter2D(img,-1,kernel)
    emboss = cv2.filter2D(img,-1,emboss_k)
    gass = cv2.GaussianBlur(img,(5,5),5)
    cv2.imshow("Input image",img)
    cv2.imshow("Gaussian image",gass)
    cv2.imshow("Motion blur image",motion)
    cv2.imshow("Emboss blur image",emboss)
    #cv2.imwrite(out_folder + str(idx) + .jpg,gauss)
    #idx = idx +1
    #cv2.imwrite(out_folder + os.path.basename(img_path),gauss)
    key = cv2.waitKey(0)
    if key == ord('q'):
        break
    
cv2.destroyAllWindows()























