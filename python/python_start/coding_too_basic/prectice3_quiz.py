# Quiz) 당신은 Cocoa 서비스를 이용하는 택시 기사님이다.
# 50명의 승객과 매칭 기회가 있을 때, 총 탑승 승객 수를 구하는 ㅍ로그램을 작성하시오.

# 조건1 : 승객별 운행 소요시간은 5분 ~ 50분 사이의 난수로 정해진다.
# 조건2 : 당신은 소요 시간 5분 ~ 15분 사이의 승객만 매칭해야 한다.

# (출력문 예제)
# [O] 1번 째 손님 (소요시간 : 15분)
# [ ] 2번 째 손님 (소요시간 : 50분)
# [O] 3번 째 손님 (소요시간 : 5분)
# ...
# [ ] 50번 째 손님 (소요시간 : 16분)

# 총 탑승 승객 : 2 분


from random import *
#* 총 탑승객 수
cnt = 0
#* 1 ~ 50 이라는 수 ( 승객 ) 
for i in range(1, 51):
    #* 5분 ~ 50분 소요시간
    time = randrange(5, 51)
    #* 5분 ~ 15분 이내의 손님, 탑승 승객 수 증가 처리
    if 5 <= time <= 15:
        print("[0] {0}번째 손님 (소요시간 : {1}분)".format(i, time))
        cnt += 1
    #* 매칭 실패한 경우
    else: 
        print("[ ] {0}번째 손님 (소요시간 : {1}분)".format(i, time))

print("총 탑승 승객 : {0} 분".format(cnt))












