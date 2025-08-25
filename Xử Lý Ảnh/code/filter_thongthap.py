# -*- coding: utf-8 -*-
"""
Created on Sun Mar 19 17:26:28 2023

@author: Pham Ba Huy
"""

import cv2
import numpy as np
from scipy import fftpack

# Đọc video từ tệp
cap = cv2.VideoCapture('video1.mkv')

# Lấy kích thước khung hình
width = int(cap.get(cv2.CAP_PROP_FRAME_WIDTH))
height = int(cap.get(cv2.CAP_PROP_FRAME_HEIGHT))

# Tạo bộ lọc thông thấp trong miền tần số
cutoff_freq = 30
filter = np.ones((height, width))
filter[cutoff_freq:-cutoff_freq, cutoff_freq:-cutoff_freq] = 0

# Lặp qua các khung hình trong video
while True:
    # Đọc một khung hình mới
    ret, frame = cap.read()
    if not ret:
        break
        
    # Chuyển đổi khung hình sang miền tần số bằng phép biến đổi Fourier rời rạc 2 chiều
    frame_fft = fftpack.fft2(frame)
    
    # Áp dụng bộ lọc thông thấp trong miền tần số bằng cách loại bỏ các thành phần tần số cao
    filtered_fft = frame_fft * filter
    
    # Chuyển đổi khung hình trở lại miền thời gian bằng phép biến đổi Fourier nghịch rời rạc 2 chiều
    filtered_frame = np.real(fftpack.ifft2(filtered_fft))
    
    # Chuyển đổi định dạng pixel từ số thực sang số nguyên 8 bit
    filtered_frame = np.uint8(filtered_frame)
    
    # Hiển thị khung hình đã được lọc
    cv2.imshow('Filtered Frame', filtered_frame)
    
    # Nhấn phím 'q' để thoát khỏi vòng lặp
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break
    
# Giải phóng tài nguyên và đóng tệp video
cap.release()
cv2.destroyAllWindows()
