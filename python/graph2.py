import numpy as np
from scipy import signal, interpolate
from matplotlib import pylab as plt

# サンプルデータ作成(1秒間隔で10秒間)
#x = np.linspace(0, 10, 11)
x = [0, 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9, 10.1]
y = np.sin(x)

#tt = np.linspace(0, 10, 51)
tt = np.linspace(0, 10, 11)

# 線形補間
f1 = interpolate.interp1d(x, y, kind='linear', axis=-1)
# 3次スプライン補間
f2 = interpolate.interp1d(x, y, kind='cubic')

plt.plot(x, y, marker='.', label="dot",  color="red")
plt.plot(tt, f1(tt), "m", label="Linear Interpolation",  color="black")
plt.plot(tt, f2(tt), "r", label="Cubic Spline Interpolation",  color="orange")

plt.grid(True)
plt.legend(bbox_to_anchor=(1, 1), loc='upper right', borderaxespad=0)
#plt.show()

# グラフをPNGで保存
plt.savefig('graph2.png')
