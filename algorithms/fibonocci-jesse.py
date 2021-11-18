from functools import lru_cache


# manual memoization
def fibo(n):
    return _fibo(n, {0: 0, 1: 1})


def _fibo(n, known):
    if n not in known:
        known[n] = _fibo(n - 1, known) + _fibo(n - 2, known)
    return known[n]


# manual tab
def fib_tab(n):
    known = {0: 0, 1: 1}
    for i in range(2, n+1):
        known[i] = known[i-1] + known[i-2]
    return known[n]


# auto memoization
@lru_cache
def fibo_cache(n):
    if n in {0, 1}:
        return n
    return fibo_cache(n - 1) + fibo_cache(n - 2)


if __name__ == '__main__':
    num = 100
    print(fibo(num))
    print(fib_tab(num))
    print(fibo_cache(num))
