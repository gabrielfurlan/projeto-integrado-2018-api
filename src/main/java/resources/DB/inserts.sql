
## INSERTS

use projeto_integrado;

# insert analyst 
insert into users (id, first_name, last_name, email, password, role) values ('5fd26220-6c08-4a01-acf2-96c2d8470d81', 'Gabriel', 'Furlan', 'gabriel@loop.com.br', '$2a$11$48vS5/o9PhB.f4jIJnEr6er8udNVAp.fVTM31MOSDaYO6xa3JKfYy', 'manager');
insert into analysts (id, user_id) values ('19cf8a55-3a34-4f25-82f9-166f17757a40', '5fd26220-6c08-4a01-acf2-96c2d8470d81');
update users set analyst_id = '19cf8a55-3a34-4f25-82f9-166f17757a40' where id = '5fd26220-6c08-4a01-acf2-96c2d8470d81';

# insert manager
insert into users (id, first_name, last_name, email, password) values ('5381efae-5e8b-4e43-9853-cf35fa3a4756', 'Rafael', 'Silva', 'rafael@loop.com.br', '$2a$11$48vS5/o9PhB.f4jIJnEr6er8udNVAp.fVTM31MOSDaYO6xa3JKfYy');
insert into managers (id, user_id) values ('f39478b9-a0cf-4a93-b444-60886a71e714', '5381efae-5e8b-4e43-9853-cf35fa3a4756');
update users set manager_id = 'f39478b9-a0cf-4a93-b444-60886a71e714' where id = '5381efae-5e8b-4e43-9853-cf35fa3a4756'; 

# insert sectors
insert into sectors (id, name) values ('5381efae-5e8b-4e43-9853-cf35fa3a4756', 'Internet');
insert into sectors (id, name) values ('f39478b9-a0cf-4a93-b444-60886a71e714', 'Saúde');

