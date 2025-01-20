# i번째 날 사고 j번째 날 팔면 aj - ai 만큼 이득 => 최대 이득 구하기
import sys
input = sys.stdin.readline

n = int(input()) # N일간 주식 판매 진행
a = list(map(int, input().split()))

def max_profit(prices):
    min_price = prices[0]
    max_profit = 0

    for price in prices:
        if price < min_price:
            min_price = price
        profit = price - min_price
        if profit > max_profit:
            max_profit = profit

    return max_profit

print(max_profit(a))