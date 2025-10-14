from qiskit import QuantumCircuit, transpile
from qiskit_aer import Aer, AerSimulator
import matplotlib.pyplot as plt

# 회로 생성
qc = QuantumCircuit(2)         # 두 큐비트로 새로운 양자 회로 생성
qc.x(0)                        # q(0)에 X 게이트 추가
#qc.h(0)                       # q(0)에 Hadamard 게이트 추가
#qc.cx(0,1)                    # 제어 큐빗 : q0, 타깃 큐빗 : q1
qc.measure_all()               # 모든 큐비트 측정

qc.draw("mpl")
plt.savefig("hello_aer.png")

# AER 시뮬레이터 실행
backend = AerSimulator()
tqc = transpile(qc, backend)
job = backend.run(tqc, shots=1024)
result = job.result()

# 결과 출력
counts = result.get_counts()
print("AER counts:", counts)

bitstrings = []
for bit, cnt in counts.items():
    bitstrings.extend([bit] * cnt)
print("AER bitstrings:", bitstrings[:10])
