#importing the necessary libraries

import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

from sklearn.model_selection import train_test_split
from sklearn.tree import DecisionTreeClassifier, plot_tree
from sklearn.ensemble import RandomForestClassifier
from sklearn.metrics import accuracy_score

# ignore the warning messages
import warnings
warnings.filterwarnings('ignore')




# read dataset from a Google Drive File

file_link = 'https://drive.google.com/file/d/1wADS0ybifgQJcPEtzqDurKAi_CEmwKDF/view?usp=sharing' # the file access must have to be Public

# get the id part of the file
id = file_link.split("/")[-2]
# print(id)

# creating a new link using the id so that we can easily read the csv file in pandas
new_link = f'https://drive.google.com/uc?id={id}'
print(new_link)
df = pd.read_csv(new_link)

# let's look at the first few instances
df.head(10)





df.shape


df.info()


df.describe(include='all')



# Check Unique Values
df.nunique()


# Check for missing values
df.isnull().sum()



#check the cat and num column name
cat_cols = df.select_dtypes(include=['object']).columns.tolist()
num_cols = df.select_dtypes(include=np.number).columns.tolist()
print("Categorical Variables:")
print(cat_cols)
print("Numerical Variables:")
print(num_cols)



# Visualize the distribution of the 'Survived' variable

print(df.value_counts('Survived'))

plt.figure(figsize=(5, 3))
df['Survived'].value_counts().plot(kind='bar', color=['lightcoral', 'lightgreen'])
plt.title('Survival Distribution')
plt.xlabel('Survived')
plt.ylabel('Survival Count')
plt.xticks(rotation = 45)
plt.show()




# Visualize the distribution of 'Pclass' variable
print(df.value_counts('Pclass').sort_index())

plt.figure(figsize=(5, 3))
df['Pclass'].value_counts().sort_index().plot(kind='bar', color='slategrey')
plt.title('Passenger Class Distribution')
plt.xlabel('Pclass')
plt.ylabel('Count')
plt.xticks(rotation=0)
plt.show()





# Visualize the distribution of 'Sex' variable
print(df.value_counts('Sex'))

plt.figure(figsize=(5, 3))
df['Sex'].value_counts().plot(kind='bar', color=['dimgray', 'magenta'])
plt.title('Gender Distribution')
plt.xlabel('Sex')
plt.ylabel('Count')
plt.xticks(rotation=90)
plt.show()





# Visualize the distribution of 'Age' variable
plt.figure(figsize=(8, 5))
plt.hist(df['Age'].dropna(), edgecolor='black')
# dropna eliminates the null/missing values but not in df
plt.title('Age Distribution')
plt.xlabel('Age')
plt.ylabel('Count')
plt.show()





# Visualize the relationship between 'Pclass' and 'Survived'

plt.figure(figsize=(6, 4))
pd.crosstab(df['Pclass'], df['Survived']).plot(kind='bar', color=['lightcoral', 'lightgreen'])
plt.title('Survival by Passenger Class')
plt.xlabel('Pclass')
plt.ylabel('Count')
plt.xticks(rotation=0)
plt.show()








# Visualize the relationship between 'Sex' and 'Survived'
plt.figure(figsize=(6, 4))
pd.crosstab(df['Sex'], df['Survived']).plot(kind='bar', color=['lightcoral', 'lightgreen'])
plt.title('Survival by Gender')
plt.xlabel('Sex')
plt.ylabel('Count')
plt.xticks(rotation=0)
plt.show()







# Correlation matrix plot
plt.figure(figsize=(8, 6))
correlation_matrix = df.corr(numeric_only=True)
print(correlation_matrix)
plt.matshow(correlation_matrix)
plt.title('Correlation Matrix')
plt.xticks(range(len(correlation_matrix.columns)), correlation_matrix.columns, rotation=90)
plt.yticks(range(len(correlation_matrix.columns)), correlation_matrix.columns)
plt.colorbar()
plt.show()







# Drop redundant features/columns
df = df.drop(['PassengerId', 'Name', 'Ticket', 'Cabin'], axis=1) #axis=1 is column, 0 is row
df




# Drop duplicates
df = df.drop_duplicates()
df



# Handle missing values in the column "Age" by replacing with the mean value
df['Age'].fillna(df['Age'].mean(), inplace = True) #changing df permanently
df



# Drop rows with missing values
df.dropna(subset=['Embarked'], inplace=True)
df




df.shape


df.isnull().sum()


# Convert categorical variables to numerical (one-hot encoding)
df = pd.get_dummies(df, columns=['Sex', 'Embarked'])
df



df.shape



# Split the data into 80-20 train-test split

X = df.drop(['Survived'], axis=1) # features
y = df['Survived'] # target column

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)



# display the shapes

print("X_train shape:", X_train.shape)
print("X_test shape:", X_test.shape)
print("y_train shape:", y_train.shape)
print("y_test shape:", y_test.shape)



# Implementing Decision Tree Classifier
decision_tree_model = DecisionTreeClassifier(criterion='gini', max_depth = 10, random_state=42)
decision_tree_model.fit(X_train, y_train)

# Predictions on the test set
y_pred_dt = decision_tree_model.predict(X_test)

# Evaluate the model
print("Decision Tree Classifier Accuracy:", accuracy_score(y_test, y_pred_dt))
#accuracy = no.of correctly predicted data / total test data

# Visualize the Decision Tree
plt.figure(figsize=(60, 40))
plot_tree(decision_tree_model, feature_names=X.columns, class_names=['Not Survived', 'Survived'], filled=True, rounded=True)
plt.title('Decision Tree Visualization')
plt.show()




# Implementing Random Forest Classifier
random_forest_model = RandomForestClassifier(n_estimators=100, max_depth = 5, criterion='gini', bootstrap=True, random_state=42)
random_forest_model.fit(X_train, y_train)

# Predictions on the test set
y_pred_rf = random_forest_model.predict(X_test)

# Evaluate the model
print("Random Forest Classifier Accuracy:", accuracy_score(y_test, y_pred_rf))

# Visualize one of the decision trees (first tree) in the Forest
plt.figure(figsize=(60, 40))
plot_tree(random_forest_model.estimators_[0], feature_names=X.columns, class_names=['Not Survived', 'Survived'], filled=True, rounded=True)
plt.title('First Decision Tree Visualization (from Random Forest)')
plt.show()







# Implementing Decision Tree and Random Forest from Scratch

class DecisionTree:
    def __init__(self, max_depth = None):
        ### Your Code Here ###

        self.max_depth = max_depth  # Written for solve (Roudro)

        pass

    def fit(self, X, y, depth = 0):
        # if all elements in y are the same or depth is equal to the maximum depth:
        #     return a leaf node with the majority class in y

        # Find the best feature and threshold to split the data using Gini Impurity
        best_feature, best_threshold = self.find_best_split(X, y)

        # Split the data into left and right subsets based on the best split

        # Recursively build the tree
        # left_node = fit(left_subset, left_labels, depth + 1)
        # right_node = fit(right_subset, right_labels, depth + 1)

        # return a decision node with feature, threshold, left_node, and right_node
        pass

    def find_best_split(self, X, y): # For Solve: Returns Best Feature and best Threshold (Roudro)
        ### Your Code Here ###
        return (None, None)

    #create another method to calculate gini impurity if needed

    def predict(self, node, x):
        # if node is a leaf node:
        #     return the class of the leaf node
        # else:
        #     if instance's feature value <= node's threshold:
        #         return predict(node's left_node, instance)
        #     else:
        #         return predict(node's right_node, instance)
        pass


# converting Pandas dataframe to NumPy Array
X_train_np = X_train.to_numpy()
y_train_np = y_train.to_numpy()
X_test_np = X_test.to_numpy()
y_test_np = y_test.to_numpy()


# Create the model and fit the training data
decision_tree = DecisionTree(max_depth=5)
final_tree = decision_tree.fit(X_train_np, y_train_np) # returns the information of the final tree in a suitable data structure

# Predictions on the test set
y_pred_dt_scr = np.array([decision_tree.predict(final_tree, instance) for instance in X_test_np])

# Calculate and print the accuracy using y_test and y_pred manually
# Hint: accuracy = number of correctly predicted datapoints / total datapoints
accuracy_dt_scr = 0

### Your Code Here ###

print("Decision Tree Classifier (from scratch) Accuracy:", accuracy_dt_scr)












class RandomForest:
    def __init__(self, n_estimators = 100, max_depth = None):
        # Initialize an empty list of trees
        ### Your Code Here ###
        pass

    def fit(self, X, y):
        # Loop upto n_estimators:
        #     Create a bootstrap sample (X_sample, y_sample) from the training data
        #     DT_model = DecisionTree(max_depth) [reuse the DecisionTree class above]
        #     tree = DT_model.fit(X_sample, y_sample)
        #     Append tree to the list of trees
        pass

    def predict(self, X):
        # Use majority voting to predict the class for the given instance using all trees
        pass


# Create the model and fit the training data
random_forest = RandomForest(n_estimators=25, max_depth=5)
random_forest.fit(X_train_np, y_train_np)

# Predictions on the test set
y_pred_rf_scr = random_forest.predict(X_test_np)

# Calculate the accuracy like before
accuracy_rf_scr = 0

### Your Code Here ###

print("Random Forest Classifier (from scratch) Accuracy:", accuracy_rf_scr)