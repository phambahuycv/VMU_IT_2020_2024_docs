# -*- coding: utf-8 -*-
"""
Created on Sat Feb 18 07:44:41 2023

@author: Pham Ba Huy
"""

from PIL import Image, ImageEnhance
# PIL accesses images in Cartesian co-ordinates, so it is Image[columns, rows]
img = Image.open("anhnen.jpg")

# Enhance constrast
enhancer = ImageEnhance.Contrast(img)
for i in range(1, 8):
    factor = i / 4.0
    new_img = enhancer.enhance(factor)
    new_img.save('tuongphan-%s.jpg' % i)