import configparser
import pandas as pd
import datetime

PROPERTY_PATH='./config.ini'
PROPERTY_ENCODE='UTF-8'

# プロパティファイル読み込み
inifile = configparser.ConfigParser()
inifile.read(PROPERTY_PATH, PROPERTY_ENCODE)
file_name=inifile.get('file', 'name')
file_encoding=inifile.get('file', 'encoding')
file_sep=inifile.get('file', 'sep')

print('===プロパティファイル設定値===')
print('CSVファイル名：' + file_name)
print('CSVエンコード：' + file_encoding)
print('CSVセパレータ：' + file_sep)
print('==============================')


# プロパティ書き込み
#with open(PROPERTY_PATH, "w", encoding=PROPERTY_ENCODE) as f:
#  inifile.set('test', 'update_time', datetime.datetime.now().strftime("%Y/%m/%d %H:%M:%S"))
#  inifile.write(f)


# CSV読み込み(ヘッダあり)
csv_input = pd.read_csv(filepath_or_buffer=file_name, encoding=file_encoding, sep=file_sep)
# CSV読み込み(ヘッダなし)
#csv_input = pd.read_csv(filepath_or_buffer=file_name, encoding=file_encoding, sep=file_sep, header=None)

# ソート
csv_input_sort=csv_input.sort_values(['市場', '始値'])
print(csv_input_sort['市場'])

# カラム名と値出力
for column_name, item in csv_input.iteritems():
    print(column_name)
    print(item)
    print('======\n')

# Group By
grouped = csv_input.groupby('市場')
for name, group in grouped:
    print(name)
    print(group)    
    print('======')

# 平均
print(grouped['始値'].mean())

# 合計
print(grouped.sum())

# MAX
print(grouped.max())

# MIN
print(grouped.min())

# 複数の統計量を一括算出
print(grouped.describe())

# CSV行数
print('行数=' + str(len(csv_input)))

# カラム数
print('カラム数=' + str(len(csv_input.columns)))

# 特定カラム取得
print(csv_input[["コード", "銘柄名"]])

# 全データ取得
print(csv_input.values)

# 最初のカラムから2番目まで表示
print(csv_input.values[0, 1])

#2行目3行目表示
print(csv_input.loc[1:2,["始値", "終値"]]) 

# 条件に合致するデータ表示
print(csv_input.query("出来高 > 100000 & 終値 >= 始値")) 

