# -*- coding: utf-8 -*-
"""
Created on Sat Feb 18 07:38:33 2023

@author: Pham Ba Huy
"""

import sys
import cv2
import numpy as np

def change_brightness(img, alpha, beta):
    img_new = np.asarray(alpha*img + beta, dtype=int)   # cast pixel values to int
    img_new[img_new>255] = 255
    img_new[img_new<0] = 0
    return img_new

if __name__ == "__main__":
    alpha = 1.0
    beta = 35
    if len(sys.argv) == 3:
        alpha = float(sys.argv[1])
        beta = int(sys.argv[2])
    img = cv2.imread('anhnen.jpg')       # [height, width, channel]
    
    # change image brightness g(x,y) = alpha*f(x,y) + beta
    img_new = change_brightness(img, alpha, beta)
    
    cv2.imwrite('anhnen_new.jpg', img_new)