#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <arpa/inet.h>
#include <sys/socket.h>

void error_handling(char *message);
char* send_data(char* data);
char* recv_data(char* data);
int main(int argc, char* argv[])
{
	int clnt_sock;
	int serv_sock;
	char buf[256];
	struct sockaddr_in serv_addr;
	struct sockaddr_in clnt_addr;
	socklen_t clnt_addr_size;
	char message[]="Hello World!";

	if(argc!=2)
	{
		printf("Usage : %s <port>\n",argv[0]);
		exit(1);
	}

	serv_sock = socket(AF_INET, SOCK_STREAM, 0);
	if(serv_sock == -1)
		error_handling("socket() error");

	memset(&serv_addr,0,sizeof(serv_addr));
	serv_addr.sin_family = AF_INET;
	serv_addr.sin_addr.s_addr = htonl(INADDR_ANY);
	serv_addr.sin_port = htons(atoi(argv[1]));

	if(bind(serv_sock, (struct sockaddr*) &serv_addr, sizeof(serv_addr))==-1)
		error_handling("bind() error");

	if(listen(serv_sock,5) == -1)
		error_handling("listen() error");
	
	clnt_addr_size = sizeof(clnt_addr);
	clnt_sock = accept(serv_sock,(struct sockaddr*) &clnt_addr,&clnt_addr_size);
	if(clnt_sock == -1)
		error_handling("accept() error");
	
	//hello world	
	write(clnt_sock, message, sizeof(message));
	
	int nbyte = 256, file_state;
	size_t filesize = 0, bufsize = 0;
	FILE *f = NULL;
	char filename[30];
	char file_len[4],input_len[4];
	char byte[4];	
	char OK[10];
	char NOTOK[10];

	//file name
	read(clnt_sock,file_len,4);
	file_state = read(clnt_sock,filename,atoi(file_len));	

	printf("recv_file name : %s\n",filename);
	////////////
	if(file_state==-1)
	{
		// client NOTOK
		sprintf(NOTOK,"%s",send_data("NOTOK"));
		write(clnt_sock,NOTOK,sizeof(NOTOK));
		if(listen(serv_sock,5) == -1)
			error_handling("listen error");
	}
	else
	{
		// client OK
		char path[24];
		memset(path,0,sizeof(path));
		memset(OK,0,sizeof(OK));
		strcpy(OK,send_data("OK"));
		sprintf(path,"./backup/%s",filename);
		write(clnt_sock,OK,sizeof(OK));
		printf("from client filename :%s\nwrite path : %s\n",filename,path);
		f = fopen(path,"wb");
	}
	
	bufsize = 256;

	while(nbyte!=0)
	{
		memset(buf,0,sizeof(buf));
		
		read(clnt_sock,input_len,4);
		nbyte = read(clnt_sock,buf,atoi(input_len));
		
		if (nbyte != -1)
		{	
			memset(OK,0,sizeof(OK));
			sprintf(OK,"%s",send_data("OK"));
			printf("send response : %s\n",OK);
			write(clnt_sock,OK,sizeof(OK));

			strcpy(buf,recv_data(buf));
			printf("recv data : %s",buf);
			fputs(buf,f);
			fflush(f);
		}

	}
	fclose(f);
	close(clnt_sock);
	close(serv_sock);
	return 0;
}
void error_handling(char *message)
{
	fputs(message, stderr);
	fputc('\n', stderr);
	exit(1);
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

