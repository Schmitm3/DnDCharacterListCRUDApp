import React, { useEffect, useState } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './NavBar';
import { Link } from 'react-router-dom';

const CharacterList = () => {

  const [groups, setGroups] = useState([]);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    setLoading(true);

    fetch('/api/characters/all')
      .then(response => response.json())
      .then(data => {
        setGroups(data);
        setLoading(false);
      })
  }, []);

  const remove = async (id) => {
    await fetch(`api/characters/${id}`, {
      method: 'DELETE',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      }
    }).then(() => {
      let updatedGroups = [...groups].filter(i => i.id !== id);
      setGroups(updatedGroups);
    });
  }

  if (loading) {
    return <p>Loading...</p>;
  }

  const groupList = groups.map(group => {
    return <tr key={group.id}>
      <td style={{whiteSpace: 'nowrap'}}>{group.name}</td>
      <td>{group.health}</td>
      <td>{group.characterClass}</td>
      <td>
        <ButtonGroup>
          <Button size="sm" color="primary" tag={Link} to={"/characters/" + group.id}>Edit</Button>
          <Button size="sm" color="danger" onClick={() => remove(group.id)}>Delete</Button>
        </ButtonGroup>
      </td>
    </tr>
  });

  return (
    <div>
      <AppNavbar/>
      <Container fluid>
        <div className="float-end">
          <Button color="success" tag={Link} to="/characters/new">Add Character</Button>
        </div>
        <h3>Character List</h3>
        <Table className="mt-4">
          <thead>
          <tr>
            <th width="30%">Name</th>
            <th width="20%">Health</th>
            <th width="20%">Class</th>
            <th width="30%">Actions</th>
          </tr>
          </thead>
          <tbody>
          {groupList}
          </tbody>
        </Table>
      </Container>
    </div>
  );
};

export default CharacterList;