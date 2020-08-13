Create Corana_Kit;

use Corana_Kit;

CREATE TABLE ProductMaster( Id INT(11) AUTO_INCREMENT,
ProductName VARCHAR(32),
Cost VARCHAR(32),
ProductDescription VARCHAR(100),
CONSTRAINT key1 PRIMARY KEY (Id)
);


CREATE TABLE Kit( Id INT(11) AUTO_INCREMENT,
PersonName VARCHAR(32),
Email VARCHAR(32),
ContactNumber VARCHAR(32),
Status VARCHAR(32),
OrderDate VARCHAR(32),
CONSTRAINT key1 PRIMARY KEY (Id)
);

