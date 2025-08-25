# -*- coding: utf-8 -*-
"""
Created on Sun Feb 26 14:41:23 2023

@author: Pham Ba Huy
"""

import cv2
video_path= "video1.mkv"
vc= cv2.VideoCapture(video_path)
while True:
    ret,frame = vc.read()
    if not ret:
        break
    cv2.imshow(str(video_path),frame)
    
    gauss = cv2.GaussianBlur(frame,(15,15),15)
    cv2.imshow("Gaussian filter",gauss)
    
    key=cv2.waitKey(10)
    if key == ord("q"):
        break
vc.release()
cv2.destroyAllWindows()