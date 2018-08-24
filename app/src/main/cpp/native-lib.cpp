#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring

JNICALL
Java_opengl_panjq_com_opengl_1demo_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
