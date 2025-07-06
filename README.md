## Servidor MySQL
Para executar esse exemplo é necessário que tenha um servidor MySQL disponível. Você subir um rapidamente dentro de contêiner com o Docker. Basta executar a linha abaixo:

<code>docker run -d --rm -p 3333:3306 -e MYSQL_ROOT_PASSWORD=senhaRoot -e MYSQL_DATABASE=bcd -e MYSQL_USER=aluno -e MYSQL_PASSWORD=aluno -e MYSQL_ROOT_HOST='%' --name meumysql mysql:latest </code>

Cabe lembrar que sempre que o contêiner for parado, ele será excluído (opção --rm no comando acima) e todos os dados serão perdidos. Se quiser que os dados continuem mesmo depois da parada e exclusão do contêiner, então passe o parâmetro -v $(pwd)/db_data:/var/lib/mysql que fará o mapeamento do diretório usado pelo MySQL no contêiner para um diretório no computador hospedeiro.