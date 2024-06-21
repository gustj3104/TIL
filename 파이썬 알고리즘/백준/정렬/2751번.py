'''
import sys

class Node():
    def __init__(self, key):
        self.key = key
        self.right = None
        self.left = None
    
    def __str__(self):
        return str(self.key)

class QuickSort():
    def __init__(self):
        self.head = None
        self.tail = None

    def append(self, key):
        new_node = Node(key)
        if self.tail == None:
            self.head = self.tail = new_node
        else:
            self.tail.right = new_node
            new_node.left = self.tail
            self.tail = new_node

    def to_list(self):
        result = []
        current = self.head
        while current:
            result.append(current.key)    
            current = current.right
        return result
    
    def partition(self, start, end):
        pivot = end
        i = start.left
        current = start

        while current != end:
            if current.key < pivot.key:
                if i is None:
                    i = start
                else:
                    i = i.right
                i.key, current.key = current.key, i.key
            current = current.right

        i = start if i is None else i.right
        i.key, end.key = end.key, i.key
        # print(i)
        return i

    def _quick_sort(self, start, end):
        if start and end and start != end and start != end.right:
            p = self.partition(start, end)
            self._quick_sort(start, p.left)
            self._quick_sort(p.right, end)

    def quick_sort(self):
        self._quick_sort(self.head, self.tail)

n = int(sys.stdin.readline())
linked_list = QuickSort()
for _ in range(n):
    linked_list.append(int(sys.stdin.readline()))

linked_list.quick_sort()

sorted_list = linked_list.to_list()
for num in sorted_list:
    print(num)
'''


import sys

n = int(input())
num = []
for _ in range(n):
    num.append(int(sys.stdin.readline()))

num.sort()

for i in num:
    print(i)