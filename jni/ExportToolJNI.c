#include <jni.h>
#include <stdlib.h>
#include <string.h>
#include <windows.h>
#include "online_zhaopei_myproject_common_tool_ExportTool.h"

#define BUFFSIZE 4096

JNIEXPORT void JNICALL Java_online_zhaopei_myproject_common_tool_ExportTool_hello(JNIEnv *env, jclass thisobj, jstring name) {

    const jbyte *str;
    str = (*env)->GetStringUTFChars(env, name, NULL);
    printf("hello world! %s\n", str);
}

JNIEXPORT void JNICALL Java_online_zhaopei_myproject_common_tool_ExportTool_generateExportFile
  (JNIEnv *env, jclass thisobj, jint type, jstring sqlPathName, jstring exportPathName) {

    char buf[BUFFSIZE] = "sqluldr264 header=true text=csv user=";
    char sql[256] = " sql=", file[256] = " file=";
    const jbyte *pSqlPathName;
    const jbyte *pExportPathName;
    pSqlPathName = (*env)->GetStringUTFChars(env, sqlPathName, NULL);
    pExportPathName = (*env)->GetStringUTFChars(env, exportPathName, NULL);
    if (NULL == pSqlPathName || NULL == pExportPathName) {
        return;
    }
    strcat(sql, pSqlPathName);
    strcat(file, pExportPathName);
    if (0 == type) {
       strcat(buf, "ecssent/dbwork@//172.16.0.140:1525/tybwtfw");
    }
    strcat(buf, sql);
    strcat(buf, file);
    printf("command is: %s\n", buf);
    //system(buf);
}