group_number = 1
while True:
    group = []
    nasty_student = []
    flag = 0
    n = int(input())
    if n == 0:
        break

    print(f"Group {group_number}")

    for i in range(n):
        data = input().split()
        name, message = data[0], data[1:]  # 첫 번째 단어는 이름, 나머지는 메시지 리스트
        group.append(name)

        # 메시지에서 'N'이 있는 위치를 찾고, 해당 학생의 인덱스 계산
        for idx, msg in enumerate(message):
            if msg == "N":
                student = (i - (idx + 1)) % n  # 왼편으로 종이를 전달했을 때 원 소유자
                nasty_student.append((student, i))
                flag = 1

    for n, i in nasty_student:
        print(f"{group[n]} was nasty about {group[i]}")

    if flag == 0:
        print("Nobody was nasty")

    group_number += 1
    print("")
