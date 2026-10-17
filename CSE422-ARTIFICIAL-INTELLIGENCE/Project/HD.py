import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

patient=pd.read_csv("/Users/mehedihasanroudro/Library/CloudStorage/OneDrive-MicrosoftOffice365/CSE-UNDERGRAD-BRACU/CSE422-ARTIFICIAL-INTELLIGENCE/Project/heart_disease.csv")
df=patient.copy()
df.head()

df.info()


df.isnull().sum()


print("Shape before dropping unnecessary columns:", df.shape)
df=df.drop(['id', 'dataset'], axis=1)
print("Shape after dropping unnecessary columns:", df.shape)



df['num'] = (df['num'] > 0).astype(int)



from sklearn.impute import SimpleImputer

numeric_cols=['trestbps', 'chol', 'thalch', 'oldpeak']
imputer_numeric=SimpleImputer(strategy='mean')
df[numeric_cols]=imputer_numeric.fit_transform(df[numeric_cols])

imputer_ca=SimpleImputer(strategy='median')
df['ca']=imputer_ca.fit_transform(df[['ca']])

categorical_cols=['fbs','restecg','exang','slope','thal']
imputer_categorical=SimpleImputer(strategy='most_frequent')
df[categorical_cols]=imputer_categorical.fit_transform(df[categorical_cols])

df


df.info()


binary_cols=['sex','fbs','exang']
for col in binary_cols:
    print(f"Unique values in column '{col}': {df[col].unique()}")
    
    
from sklearn.preprocessing import LabelEncoder

enc = LabelEncoder()
encoding_map = {}
for col in binary_cols:
    df[col]=enc.fit_transform(df[col])
    encoding_map[col] = {k: int(v) for k, v in zip(enc.classes_, enc.transform(enc.classes_))}
print(df[binary_cols].head())



for col in binary_cols:
    print(f"Unique values in column '{col}': {df[col].unique()}")
    
    
    
multiclass_cols=['cp','restecg','slope','thal']

df_before = df.copy()

for col in multiclass_cols:
    unique_val=df[col].unique()
    mapping={}
    i=0
    for val in unique_val:
        mapping[val]=i
        i+=1
    df[col]=df[col].map(mapping)
    encoding_map[col] = {k: int(v) for k, v in mapping.items()}
    
    
    
for col in multiclass_cols:
    print(df[[col]].head())
    
    

# show BEFORE vs AFTER side by side
before = df_before[multiclass_cols].add_suffix('_before')
after = df[multiclass_cols].add_suffix('_after')
# print(df_before)
print(pd.concat([before, after], axis=1).head())



df.head()



print("Encoding Map:", encoding_map)



from sklearn.model_selection import train_test_split


X=df.drop('num', axis=1)
y=df['num']

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42, stratify=y)

print(X_train.shape)
print(X_test.shape)



from sklearn.preprocessing import StandardScaler

scaler = StandardScaler()

X_train_scaled = scaler.fit_transform(X_train)
X_test_scaled = scaler.transform(X_test)



print(X_train_scaled)



print(X_test_scaled)



from sklearn.neighbors import KNeighborsClassifier
k_values = range(1, 21)
k_scores = []

for k in k_values:
    knn_temp = KNeighborsClassifier(n_neighbors=k)
    knn_temp.fit(X_train_scaled, y_train)
    k_scores.append(knn_temp.score(X_test_scaled, y_test))

best_k = k_values[np.argmax(k_scores)]
print(f"Best k = {best_k}, Accuracy = {max(k_scores):.2f}")

knn = KNeighborsClassifier(n_neighbors=best_k)


knn.fit(X_train_scaled, y_train)

prediction = knn.predict(X_test_scaled)
print("Prediction:", prediction)

print("Test set score: {:.2f}".format(knn.score(X_test_scaled, y_test)))

# Training KNN on the scaled training data
knn.fit(X_train_scaled, y_train)

# scoring on the scaled test set
print("KNN test accuracy after Standard Scalar: {:.2f}".format(knn.score(X_test_scaled, y_test)))