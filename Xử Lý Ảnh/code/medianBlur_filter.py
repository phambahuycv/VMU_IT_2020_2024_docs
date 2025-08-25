# -*- coding: utf-8 -*-
"""
Created on Sun Feb 26 14:59:11 2023

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
    
    blurr = cv2.medianBlur(frame,5)
    cv2.imshow("MedianBlur filter",blurr)
    
    key=cv2.waitKey(10)
    if key == ord("q"):
        break
vc.release()
cv2.destroyAllWindows()