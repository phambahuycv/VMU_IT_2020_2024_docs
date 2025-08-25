# -*- coding: utf-8 -*-
"""
Created on Sat Mar 11 17:26:45 2023

@author: Pham Ba Huy
"""

import cv2
import pytesseract
import re

pytesseract.pytesseract.tesseract_cmd = r"C:\anaconda3\tesseract.exe"



# Đọc ảnh đầu vào
img = cv2.imread('a1.png')

# Chuyển ảnh sang đen trắng
gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)

# Áp dụng phép lọc Gauss để làm mịn ảnh
gray = cv2.GaussianBlur(gray, (5, 5), 0)

# Nhận dạng chữ viết trên ảnh
text = pytesseract.image_to_string(gray, lang='vie', config='--psm 6')
text = re.sub(r'[^a-zA-Z\s]', '', text)


# In ra kết quả nhận dạng
print(text)




