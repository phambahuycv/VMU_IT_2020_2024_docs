# -*- coding: utf-8 -*-
"""
Created on Sun Feb 26 14:56:30 2023

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
    
    blurr = cv2.blur(frame,(5,5))
    cv2.imshow("Blur filter",blurr)
    
    key=cv2.waitKey(10)
    if key == ord("q"):
        break
vc.release()
cv2.destroyAllWindows()