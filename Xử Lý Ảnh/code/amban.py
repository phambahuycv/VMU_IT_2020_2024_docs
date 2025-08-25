# -*- coding: utf-8 -*-
"""
Created on Sat Feb 18 08:16:21 2023

@author: Pham Ba Huy
"""

import cv2

img= cv2.imread("anhnen.jpg")
cv2.imshow("anh goc: ",img)
cv2.waitKey(5)

img=255-img

cv2.imshow("anh am ban: ",img)
cv2.waitKey()