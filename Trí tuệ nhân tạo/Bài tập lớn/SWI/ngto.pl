di(A,B):-
    N is B*B,
    N=< A,
    A mod B =:= 0.


di(A,B):-
    B<A,
    B1 is B+1,
    di(A,B1).


ktraSNT(A):-
    B is 2,
    A > 1,
    \+ di(A,B)
            -> write(A), write(' La so nguyen To');
            write(A), write(' Khong la so nguyen To').
