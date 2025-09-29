from qiskit import QuantumCircuit
from qiskit.quantum_info import Statevector
from collections import Counter
import numpy as np
import matplotlib.pyplot as plt

# 회로 생성
qc = QuantumCircuit(2)         # 두 큐비트로 새로운 양자 회로 생성
qc.x(0)                        # q(0)에 X 게이트 추가
#qc.h(0)                       # q(0)에 Hadamard 게이트 추가
#qc.cx(0,1)                    # 제어 큐빗 : q0, 타깃 큐빗 : q1
qc.measure_all()               # 모든 큐비트 측정

qc.draw("mpl")
plt.savefig("hello_window.png")

qc_no = qc.remove_final_measurements(inplace=False)
psi = Statevector.from_instruction(qc_no)
probs = psi.probabilities()
labels = [format(i, "02b") for i in range(4)]
samples = np.random.choice(labels, size=1024, p=probs)

# 결과 출력
counts = Counter(samples)
print(f"STATEVEC counts: {dict(counts)}")

bitstrings = []
for bit in labels:
    bitstrings.extend([bit] * counts.get(bit, 0))

print(f"STATEVEC bitstrings: {bitstrings[:10]}"
