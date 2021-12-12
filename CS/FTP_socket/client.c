#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>
#include <arpa/inet.h>
#include <sys/socket.h>
#include <sys/types.h>
#include <netinet/in.h>

void error_handling(char *message);
void clear_buffer();
char* send_data(char* data);
char* recv_data(char* data);
int main(int argc, char* argv[])
{
	int serv_sock,fd;
	int str_len,len;
	struct sockaddr_in serv_addr;
	char message[30], buf[BUFSIZ];
	FILE *f = NULL;
	char line_size[4];
	size_t fsize, nsize = 0;
	size_t fsize2;

	if(argc!=3)
	{
		printf("Usage : %s <IP> <PORT> \n",argv[0]);
		exit(1);
	}
	
	serv_sock = socket(AF_INET,SOCK_STREAM,0);
	
	if(serv_sock == -1)
		error_handling("socket() error");
	
	memset(&serv_addr, 0, sizeof(serv_addr));
	serv_addr.sin_family = AF_INET;
	serv_addr.sin_addr.s_addr = inet_addr(argv[1]);
	serv_addr.sin_port = htons(atoi(argv[2]));

	if(connect(serv_sock,(struct sockaddr*)&serv_addr, sizeof(serv_addr)) == -1)
		error_handling("connect() error!");
	
	str_len=read(serv_sock, message, sizeof(message)-1);
	
	if(str_len == -1)
		error_handling("read() error!");
	printf("Message from server: %s \n",message);
	memset(message,0,sizeof(message));
	
	f = fopen("ex02_04.c","rb");
	char filename[30];
	strcpy(filename,send_data("test.c"));
	printf("send file name : %s\n",filename);

	write(serv_sock,filename,sizeof(filename));
	fseek(f,0,SEEK_END);
	fsize=ftell(f);
	fseek(f,0,SEEK_SET);
	
	//file OK/NOTOK
	read(serv_sock,line_size,4);
	read(serv_sock,message,atoi(line_size));
	printf("recive : %s\n",message);
	memset(message,0,sizeof(message));
	/////////////////////////////////
	char line[256]="";
	char form[256];

	while (!feof(f))
	{
		
		memset(line_size, 0,sizeof(line_size));
		memset(form, 0, sizeof(form));

		//send data.
		fgets(line,sizeof(line),f);
		strcpy(line,send_data(line));
		printf("send line: %s\n",line);
		write(serv_sock,line,strlen(line));
		memset(line,0,sizeof(line));
	
		//OK to serve
		read(serv_sock,line_size,4);
		read(serv_sock,message,atoi(line_size));

		printf("recv state: %s\n",message);
	//	printf("server state : %s\n",message);
		memset(message,0,sizeof(message));
	}

	fclose(f);
	close(serv_sock);
	return 0;
}


void error_handling(char *message)
{
	fputs(message, stderr);
	fputc('\n', stderr);
	exit(1);
}

void clear_buffer()
{
	while(getchar() !='\n');
}

char* send_data(char * data)
{
	static char send_form[255] ={'0',};
	sprintf(send_form,"%04d",strlen(data));
	strcat(send_form,data);
	return send_form;
}
char* recv_data(char* data)
{
	static char recv_form[255] = {'0',};
	strncpy(recv_form,data+4,strlen(data));
	return recv_form;
}
