#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_weathernowlater_utils_ApiKeyProvider_getApiKey(JNIEnv *env, jobject thiz) {
    std::string api_key = "ffb547f0b0d7147f9eac06165aab764c";
    return env->NewStringUTF(api_key.c_str());
}
