# 16 is a square of the number 4
# 12 is not a square of any number

def squarePossible(x):
    L = 0
    R = x
    while L <= R:
        mid = L + (R - L)//2
        if mid*mid == x:
            return mid
        elif mid*mid < x:
            L = mid + 1
        else:
            R = mid - 1
    return -1
n = int(input("Enter the number :"))
print(squarePossible(n))