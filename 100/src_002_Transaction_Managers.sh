<persistence xmlns="http://java.sun.com/xml/ns/persistence"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation=
      "http://java.sun.com/xml/ns/persistence 
      persistence_1_0.xsd"
  version="1.0">	
    <persistence-unit name="default" 
        transaction-type="JTA">
      <jta-data-source>jdbc/Calypso</jta-data-source>
      <exclude-unlisted-classes>false
      </exclude-unlisted-classes>
      <properties />
    </persistence-unit>
</persistence>
