# roh-cli
java command line tool for making my life a a bit easier. 1. can try port, 2. can create project skeleton, 3. can create markdown syntax for folder structure (come with web interface)

# project structure

- dist/: for compiled .exe and whole jre 1.8_202
- roh-cli: command line interface wrapping around roh-core

# examples

```bash
### ping, telnet ###
# first arg: `ping` to use check port open util
# second arg: domain name or ip
# third arg: port number
roh ping rohim.cc 80

### split large file by lines ###
# first arg: `spf`, `splitfile` to use splitfile util
# second arg: file path
# third arg: lines per file
roh spf "D:\abc.sql" 50000

### print fixed length random string on console ###
# first arg: `ranstr`, `randomstr` to use random string util
# second arg: length of random string
# third arg: number of random strings
roh ranstr 15 5

### listen to port ###
# first arg: `listen` to use listen port util
# second arg: port number
roh listen 80
```
