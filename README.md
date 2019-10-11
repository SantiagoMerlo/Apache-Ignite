# Apache Ignite
## Configuraciones Basicas para apache Ignite

Repositorio para ver las versiones de apache Ignite:
https://search.maven.org/classic/#search%7Cgav%7C1%7Cg%3A%22org.apache.ignite%22%20AND%20a%3A%22ignite-core%22

Obligatorios:
- Ignite-core 
- Ignite-Indexing

## Documentacion:

https://apacheignite.readme.io/docs

## TCP Example XML

https://apacheignite.readme.io/docs/tcpip-discovery

## Install Apache Ignite:

1 - sudo bash -c 'cat <<EOF > /etc/apt/sources.list.d/ignite.list
2 - deb http://apache.org/dist/ignite/deb/ apache-ignite main
3 - EOF'
4 - sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv-keys 379CE192D401AB61
5 - sudo apt update


## Iniciar Ignite desde la consola:


- Para iniciar Ignite:
./ignite.sh
- Para configurar la IP, PORT y especificar el esquema a utilizar:
./sqlline.sh --color=true --verbose-true -u jdbc:ignite:thin://127.0.0.1/
- Y listo ya se puede trabajar tranquilamente como un cliente de base de datos

## Apache ignite web Console

- Link para iniciar Demo

https://console.gridgain.com/configuration/overview


## Resumen Apache Ignite SQL

https://ignite.apache.org/features/sql.html

## Apache Ignite y Pentaho

https://apacheignite-tools.readme.io/docs/pentaho





# Protocolo SPI

TcpDiscoverySpi spi = new TcpDiscoverySpi();
spi.setLocalPort(48500);
TcpDiscoveryMulticastIpFinder tdm = new TcpDiscoveryMulticastIpFinder();
tdm.setAddresses(Arrays.asList("172.0.0.1"));
spi.setIpFinder(tdm);
cnf.setDiscoverySpi(spi);
 

# Apache-Ignite
