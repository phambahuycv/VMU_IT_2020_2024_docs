# -*- coding: utf-8 -*-
"""
Created on Sat Feb 18 08:31:46 2023

@author: Pham Ba Huy
"""

import cv2
import numpy as np
import matplotlib.pyplot as plt

img = cv2.imread("anhnen.jpg")

hist= np.zeros((256,), np.uint8)
[w,h]=img.shape[:2]

for i in range(w):
    for j in range(h):
        hist[img[i][j]]+=1
        
fig= plt.figure()
plt.plot(hist)
plt.show()