# clj-hector

A simple Clojure client for Cassandra that wraps Hector

## Usage

    (def c (cluster "Pauls Cluster" "localhost"))
    (def ks (keyspace c "Twitter"))
    (get-rows ks "Users" ["paul"])

    (-> (cluster "Pauls Cluster" "localhost")
        (keyspace "Twitter")
        (get-rows "Users" ["paul"]))

## TODO

* Turn off spurious logging by default
* Serialization of non-String types
* Better support of CassandraHostConfigurator
* Type hints to avoid reflecting
* Plenty more :)

## License

Copyright (c) Paul Ingles

Distributed under the Eclipse Public License, the same as Clojure.
