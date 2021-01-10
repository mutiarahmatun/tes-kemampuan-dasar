//
// Created by mutia on 25/11/20.
//

#include <jni.h>
#include <iostream>
#include <vector>
#include <iomanip>
#include <stdlib.h>
#include <jni.h>

using namespace std;

extern "C" JNIEXPORT jstring JNICALL
Java_id_ac_ui_cs_mobileprogramming_mutiarahmatun_tkd_HomeFragment_generateName(
    JNIEnv *env,
    jobject obj,
    jint length) {
    // TODO: implement generateName()

    char consonents[] = {'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','z'};
    char vowels[] = {'a','e','i','o','u','y'};

    string name = "";

    srand(time(NULL));
    int count = 0;

    for(int i = 0; i < length; i++) {
        if (i == 7) {
            name = name + " ";
        }

        if(i%2 != 0) {
            name = name + consonents[rand() % 19];
            count++;
        }
        else {
            name = name + vowels[rand() % 5];
            count = 0;
        }
    }

    name[0] = toupper(name[0]);
    return (env)->NewStringUTF(name.c_str());
}