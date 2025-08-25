dk(0,1).
dk(N,F):-
    N>0,
    N1 is N-1,
    dk(N1,F1),
    F is N*F1.
th(N,K,P):-
    dk(N,FN),
    dk(N-K,FN1),
    P is FN/FN1.
npk:-
    write('n= '), read(N),
    write('k= '), read(K),
    th(N,K,P),
    write(K),write('P'), write(N),write(' = ') ,write(P).
