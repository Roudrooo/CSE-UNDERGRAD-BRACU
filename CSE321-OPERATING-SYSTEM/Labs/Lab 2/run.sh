#!/bin/bash
f(){
echo $1
f $1
}

f "Hello"
