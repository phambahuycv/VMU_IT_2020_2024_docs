# -*- coding: utf-8 -*-
"""
Created on Sat Feb 18 09:10:20 2023

@author: Pham Ba Huy
"""

import cv2
import numpy as np

# Đọc ảnh đầu vào
img = cv2.imread('anhnen.jpg', cv2.IMREAD_GRAYSCALE)

# Tính giá trị mức xám nhỏ nhất và lớn nhất trong ảnh
min_val, max_val, min_loc, max_loc = cv2.minMaxLoc(img)

# Tính độ tương phản của ảnh
contrast = (max_val - min_val) / (max_val + min_val)

# Hiển thị giá trị độ tương phản
print('Contrast:', contrast)

