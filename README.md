# bomber-base

Simple java application to create tasks for core module. 

## Usage

You can run this module in docker with rabbitmq with it.

1. mvn clean package
2. docker build -t bomber-base .
3. docker run -d --network bomber_net --name bomber-base bomber-base

## TODO
#### Tests

#### Logging

#### Services

## License 

Copyright © 2021 Vjattich 

This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary Licenses when the conditions for such availability set forth in the Eclipse Public
License, v. 2.0 are satisfied: GNU General Public License as published by the Free Software Foundation, either version 2 of the License, or (at your option) any
later version, with the GNU Classpath Exception which is available at https://www.gnu.org/software/classpath/license.html.
