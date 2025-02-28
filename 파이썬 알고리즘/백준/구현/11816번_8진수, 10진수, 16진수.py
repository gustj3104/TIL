import sys
input = sys.stdin.readline

hex_number = input().strip()

if hex_number.lower().startswith('0x'): # 16진수
    hex_number = hex_number[2:]
    decimal_number = int(hex_number, 16)
    print(decimal_number)
elif hex_number.startswith('0'): # 8진수
    hex_number = hex_number[1:]
    decimal_number = int(hex_number, 8)
    print(decimal_number)
else: # 10진수
    print("".join(hex_number))