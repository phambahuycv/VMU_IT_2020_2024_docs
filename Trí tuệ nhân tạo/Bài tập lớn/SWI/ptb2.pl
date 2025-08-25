ptb2:-
   write('Nhap a= '), read(A),
   write('Nhap b= '), read(B),
   write('Nhap c= '), read(C),
   A=0, B= 0, C= 0 -> write('Phuong Trinh Vo So Nghiem'),
   A=0, B= 0, C=:=0 -> write('Phuong Trinh Vo Nghiem'),
   A=0, B=:=0-> write('Phuong Trinh Co 1 Nghiem: x= ',C/A),
   D= B*B-4*A*C,
   D<0-> write('Phuong Trinh Vo Nghiem'),
   D=0-> write('Phuong Trinh Co Nghiem Kep: x1 = x2 = ',-B/(2*A)),
   D>0-> write('Phuong Trinh Co 2 Nghiem Phan Biet: x1= ',(-B+sqrt(D))/(2*A),' x2= ',(-B-sqrt(D))/(2*A)).
