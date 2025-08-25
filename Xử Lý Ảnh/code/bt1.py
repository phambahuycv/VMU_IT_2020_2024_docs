# -*- coding: utf-8 -*-
"""
Created on Sat Feb 11 05:31:16 2023

@author: Pham Ba Huy
"""

import cv2
path= r'C:\code\anhnen.jpg'
img= cv2.imread(path)
cv2.imshow('hien thi',img)
cv2.waitKey()