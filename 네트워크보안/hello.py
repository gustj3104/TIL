from qiskit import QuantumCircuit
from qiskit_ibm_runtime import QiskitRuntimeService, SamplerV2 as Sampler
from qiskit.transpiler import generate_preset_pass_manager
from qiskit_aer import Aer
import matplotlib.pyplot as plt

# 계정 저장 (한 번만 실행하면 이후 ~/.qiskit에 저장됨)
QiskitRuntimeService.save_account(
    token="Y2AqrlDqzo1UHeLmBeOMw-933RoXpC6tWIGbnp-3U05g",  # API key
    channel="ibm_quantum_platform",
    instance="crn:v1:bluemix:public:quantum-computing:us-east:a/c5902d0d256a4fe0829e6e365a84443a:c0b4aefe-4b4e-4e12-afab-d536ef507b6d::",   # CRN
    overwrite=True
)

# 같은 채널로 서비스 생성
service = QiskitRuntimeService(channel="ibm_quantum_platform")

# 회로 생성
qc = QuantumCircuit(2)         # 두 큐비트로 새로운 양자 회로 생성
qc.x(0)                        # q(0)에 X 게이트 추가
#qc.h(0)                       # q(0)에 Hadamard 게이트 추가
#qc.cx(0,1)                    # 제어 큐빗 : q0, 타깃 큐빗 : q1
qc.measure_all()               # 모든 큐비트 측정

qc.draw("mpl")                
plt.savefig("hello.png") 

backend = Aer.get_backend("statevector_simulator")

backend = service.least_busy(operational=True, simulator=False)
print(backend.name)

# Convert to an ISA circuit and layout-mapped observables.
pm = generate_preset_pass_manager(backend=backend, optimization_level=1)
isa_circuit = pm.run(qc)

sampler = Sampler(backend)
job = sampler.run([isa_circuit]) 
print(f"job id: {job.job_id()}") #job id라는게 터미널에 뜨면 credit이 깎인것
result = job.result()

pub_result = result[0]
result_array = pub_result.data.meas.get_bitstrings()[:10]
print(result_array)
