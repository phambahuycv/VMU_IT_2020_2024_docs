# -*- coding: utf-8 -*-
"""
Created on Sat Feb 18 08:48:54 2023

@author: Pham Ba Huy
"""

import numpy
import cv2
import matplotlib.pyplot as plt

img = cv2.imread("anhnen.jpg", 0)

img = cv2.equalizeHist(img)

cv2.imshow("anh sau khi can bang his", img)
cv2.waitKey()