import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns

# ================================
# 1. LOAD DATA
# ================================
patient = pd.read_csv("/Users/mehedihasanroudro/Library/CloudStorage/OneDrive-MicrosoftOffice365/CSE-UNDERGRAD-BRACU/CSE422-ARTIFICIAL-INTELLIGENCE/Project/heart_disease.csv")
df = patient.copy()

print("First 5 rows:\n", df.head())

print("\nDataset Info:")
df.info()

print("\nMissing Values:\n", df.isnull().sum())

print("\nShape:", df.shape)


# ================================
# 2. DATASET DESCRIPTION
# ================================
print("\n===== DATASET DESCRIPTION =====")

print("Number of data points:", df.shape[0])
print("Number of features:", df.shape[1])

print("\nProblem Type: Classification")

categorical_features = df.select_dtypes(include=['object']).columns
numerical_features = df.select_dtypes(exclude=['object']).columns

print("\nCategorical Features:", categorical_features)
print("Numerical Features:", numerical_features)

print("\nEncoding Required: YES (ML models require numeric input)")


# ================================
# 3. CORRELATION HEATMAP
# ================================
plt.figure(figsize=(12,8))
sns.heatmap(df.corr(numeric_only=True), cmap='coolwarm')
plt.title("Correlation Heatmap")
plt.show()


# ================================
# 4. IMBALANCED DATASET
# ================================
class_counts = df['num'].value_counts()

print("\nClass Distribution:\n", class_counts)

plt.figure(figsize=(6,4))
sns.countplot(x='num', data=df)
plt.title("Class Distribution")
plt.xlabel("Class")
plt.ylabel("Count")
plt.show()

if class_counts.nunique() == 1:
    print("Dataset is balanced")
else:
    print("Dataset is imbalanced")


# ================================
# 5. EDA (Exploratory Data Analysis)
# ================================

# Age vs Disease
plt.figure(figsize=(6,4))
sns.histplot(data=df, x='age', hue='num', bins=30, kde=True)
plt.title("Age vs Disease")
plt.show()

# Chest Pain vs Disease
plt.figure(figsize=(6,4))
sns.countplot(x='cp', hue='num', data=df)
plt.title("Chest Pain vs Disease")
plt.show()

# Max Heart Rate vs Disease
plt.figure(figsize=(6,4))
sns.boxplot(x='num', y='thalch', data=df)
plt.title("Max Heart Rate vs Disease")
plt.show()

# Oldpeak vs Disease
plt.figure(figsize=(6,4))
sns.boxplot(x='num', y='oldpeak', data=df)
plt.title("Oldpeak vs Disease")
plt.show()


# ================================
# 6. PREPROCESSING
# ================================

print("\nBefore dropping columns:", df.shape)
df = df.drop(['id', 'dataset'], axis=1)
print("After dropping columns:", df.shape)

# Convert target to binary classification
df['num'] = (df['num'] > 0).astype(int)

# ------------------------
# HANDLE MISSING VALUES
# ------------------------
from sklearn.impute import SimpleImputer

# Numerical columns (excluding 'ca')
numeric_cols = ['trestbps', 'chol', 'thalch', 'oldpeak']
imputer_numeric = SimpleImputer(strategy='mean')
df[numeric_cols] = imputer_numeric.fit_transform(df[numeric_cols])

# Special case for 'ca'
imputer_ca = SimpleImputer(strategy='median')
df['ca'] = imputer_ca.fit_transform(df[['ca']])

# Categorical columns
categorical_cols = ['fbs','restecg','exang','slope','thal']
imputer_categorical = SimpleImputer(strategy='most_frequent')
df[categorical_cols] = imputer_categorical.fit_transform(df[categorical_cols])

print("\nMissing values after handling:\n", df.isnull().sum())


# ================================
# 7. ENCODING
# ================================
from sklearn.preprocessing import LabelEncoder

# Binary columns
binary_cols = ['sex','fbs','exang']
for col in binary_cols:
    df[col] = LabelEncoder().fit_transform(df[col])

# Multi-class columns
multiclass_cols = ['cp','restecg','slope','thal']
for col in multiclass_cols:
    df[col] = LabelEncoder().fit_transform(df[col])

print("\nEncoded dataset preview:\n", df.head())


# ================================
# 8. DATASET SPLITTING
# ================================
from sklearn.model_selection import train_test_split

X = df.drop('num', axis=1)
y = df['num']

X_train, X_test, y_train, y_test = train_test_split(
    X, y,
    test_size=0.2,
    random_state=42,
    stratify=y
)

print("\nTrain shape:", X_train.shape)
print("Test shape:", X_test.shape)

# Check stratification (optional but good)
print("\nTrain class distribution:\n", y_train.value_counts(normalize=True))
print("\nTest class distribution:\n", y_test.value_counts(normalize=True))


# ================================
# 9. FEATURE SCALING
# ================================
from sklearn.preprocessing import StandardScaler

scaler = StandardScaler()

X_train_scaled = scaler.fit_transform(X_train)
X_test_scaled = scaler.transform(X_test)


# ================================
# 10. KNN CLASSIFIER
# ================================
from sklearn.neighbors import KNeighborsClassifier
from sklearn.metrics import accuracy_score, classification_report, confusion_matrix

k_values = range(1, 21)
k_scores = []

for k in k_values:
    knn_temp = KNeighborsClassifier(n_neighbors=k)
    knn_temp.fit(X_train_scaled, y_train)
    k_scores.append(knn_temp.score(X_test_scaled, y_test))

best_k = k_values[np.argmax(k_scores)]

knn = KNeighborsClassifier(n_neighbors=best_k)
knn.fit(X_train_scaled, y_train)

y_pred_knn = knn.predict(X_test_scaled)

print("\n===== KNN RESULTS =====")
print("Best k:", best_k)
print("Accuracy:", accuracy_score(y_test, y_pred_knn))
print("Confusion Matrix:\n", confusion_matrix(y_test, y_pred_knn))
print("Classification Report:\n", classification_report(y_test, y_pred_knn))


# ================================
# 11. LOGISTIC REGRESSION
# ================================
from sklearn.linear_model import LogisticRegression

log_reg = LogisticRegression(max_iter=1000)
log_reg.fit(X_train_scaled, y_train)

y_pred_log = log_reg.predict(X_test_scaled)

print("\n===== LOGISTIC REGRESSION RESULTS =====")
print("Accuracy:", accuracy_score(y_test, y_pred_log))
print("Confusion Matrix:\n", confusion_matrix(y_test, y_pred_log))
print("Classification Report:\n", classification_report(y_test, y_pred_log))


# ================================
# 12. NEURAL NETWORK (MLP)
# ================================
from sklearn.neural_network import MLPClassifier

mlp = MLPClassifier(
    hidden_layer_sizes=(64, 32),
    activation='relu',
    solver='adam',
    max_iter=500,
    random_state=42
)

mlp.fit(X_train_scaled, y_train)

y_pred_nn = mlp.predict(X_test_scaled)

print("\n===== NEURAL NETWORK RESULTS =====")
print("Accuracy:", accuracy_score(y_test, y_pred_nn))
print("Confusion Matrix:\n", confusion_matrix(y_test, y_pred_nn))
print("Classification Report:\n", classification_report(y_test, y_pred_nn))


# ================================
# 13. K-MEANS (UNSUPERVISED)
# ================================
from sklearn.cluster import KMeans
from sklearn.decomposition import PCA
from sklearn.metrics import silhouette_score

# Use only features (ignore labels)
X_unsupervised = X_train_scaled

# Apply KMeans
kmeans = KMeans(n_clusters=2, random_state=42)
clusters = kmeans.fit_predict(X_unsupervised)

# Evaluate clustering
sil_score = silhouette_score(X_unsupervised, clusters)

print("\n===== K-MEANS CLUSTERING =====")
print("Silhouette Score:", sil_score)

# PCA for visualization
pca = PCA(n_components=2)
X_pca = pca.fit_transform(X_unsupervised)

plt.figure(figsize=(8,5))
plt.scatter(X_pca[:,0], X_pca[:,1], c=clusters)
plt.title("KMeans Clustering (PCA Reduced)")
plt.xlabel("PC1")
plt.ylabel("PC2")
plt.show()




# ================================
# 14. MODEL COMPARISON
# ================================
import matplotlib.pyplot as plt
import seaborn as sns
from sklearn.metrics import precision_score, recall_score, roc_curve, auc

# Store results
models = ['KNN', 'Logistic Regression', 'Neural Network']
accuracies = [
    accuracy_score(y_test, y_pred_knn),
    accuracy_score(y_test, y_pred_log),
    accuracy_score(y_test, y_pred_nn)
]

precisions = [
    precision_score(y_test, y_pred_knn),
    precision_score(y_test, y_pred_log),
    precision_score(y_test, y_pred_nn)
]

recalls = [
    recall_score(y_test, y_pred_knn),
    recall_score(y_test, y_pred_log),
    recall_score(y_test, y_pred_nn)
]


# ================================
# Accuracy Bar Chart
# ================================
plt.figure(figsize=(6,4))
plt.bar(models, accuracies)
plt.title("Model Accuracy Comparison")
plt.ylabel("Accuracy")
plt.show()


# ================================
# Precision & Recall Bar Chart
# ================================
x = np.arange(len(models))
width = 0.3

plt.figure(figsize=(7,4))
plt.bar(x - width/2, precisions, width, label='Precision')
plt.bar(x + width/2, recalls, width, label='Recall')

plt.xticks(x, models)
plt.title("Precision vs Recall")
plt.legend()
plt.show()


# ================================
# CONFUSION MATRICES
# ================================
from sklearn.metrics import ConfusionMatrixDisplay

ConfusionMatrixDisplay.from_predictions(y_test, y_pred_knn)
plt.title("KNN Confusion Matrix")
plt.show()

ConfusionMatrixDisplay.from_predictions(y_test, y_pred_log)
plt.title("Logistic Regression Confusion Matrix")
plt.show()

ConfusionMatrixDisplay.from_predictions(y_test, y_pred_nn)
plt.title("Neural Network Confusion Matrix")
plt.show()


# ================================
# ROC CURVE + AUC
# ================================
from sklearn.metrics import roc_auc_score

# Probabilities
y_prob_knn = knn.predict_proba(X_test_scaled)[:,1]
y_prob_log = log_reg.predict_proba(X_test_scaled)[:,1]
y_prob_nn = mlp.predict_proba(X_test_scaled)[:,1]

# ROC
fpr_knn, tpr_knn, _ = roc_curve(y_test, y_prob_knn)
fpr_log, tpr_log, _ = roc_curve(y_test, y_prob_log)
fpr_nn, tpr_nn, _ = roc_curve(y_test, y_prob_nn)

# AUC
auc_knn = auc(fpr_knn, tpr_knn)
auc_log = auc(fpr_log, tpr_log)
auc_nn = auc(fpr_nn, tpr_nn)

print("\nAUC Scores:")
print("KNN:", auc_knn)
print("Logistic Regression:", auc_log)
print("Neural Network:", auc_nn)

# Plot ROC
plt.figure(figsize=(6,5))
plt.plot(fpr_knn, tpr_knn, label=f"KNN (AUC={auc_knn:.2f})")
plt.plot(fpr_log, tpr_log, label=f"LogReg (AUC={auc_log:.2f})")
plt.plot(fpr_nn, tpr_nn, label=f"NN (AUC={auc_nn:.2f})")

plt.plot([0,1], [0,1], linestyle='--')  # random line
plt.xlabel("False Positive Rate")
plt.ylabel("True Positive Rate")
plt.title("ROC Curve Comparison")
plt.legend()
plt.show()