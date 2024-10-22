import React, { useEffect, useState } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import { FormControl } from "react-bootstrap";
import AppNavbar from './NavBar';
import Dropdown from 'react-bootstrap/Dropdown';
import DropdownButton from 'react-bootstrap/DropdownButton';

const CharacterEdit = () => {
  const initialFormState = {
    name: '',
    character_class: '',
    health: 100,
    rage: 75,
    mana: 200,
    energy: 100
  };

  const [group, setGroup] = useState(initialFormState);
  const [selectedItem, setSelectedItem] = useState(null);

  const navigate = useNavigate();
  const { id } = useParams();

  useEffect(() => {
    if (id !== 'new') {
      fetch(`/api/characters/${id}`)
        .then(response => response.json())
        .then(data => setGroup(data));
    }
  }, [id, setGroup]);

  const handleChange = (event) => {
    const { name, value } = event.target

    setGroup({ ...group, [name]: value })
  }

  const handleRoleChange = (event) => {
      console.log(event);
      setSelectedItem(event)
    }

  const handleSubmit = async (event) => {
      event.preventDefault();
      if (selectedItem === "Warrior" || group.characterClass === "Warrior") {
        await fetch(`/api/characters/warrior${group.id ? `/${group.id}` : ''}`, {
            method: (group.id) ? 'PUT' : 'POST',
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(group)
          });
          setGroup(initialFormState);
          navigate('/characters');
      } else if (selectedItem === "Wizard" || group.characterClass === "Wizard") {
        await fetch(`/api/characters/wizard${group.id ? `/${group.id}` : ''}`, {
            method: (group.id) ? 'PUT' : 'POST',
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(group)
          });
          setGroup(initialFormState);
          navigate('/characters');
      } else {
        await fetch(`/api/characters/ranger${group.id ? `/${group.id}` : ''}`, {
          method: (group.id) ? 'PUT' : 'POST',
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(group)
        });
        setGroup(initialFormState);
        navigate('/characters');
      }
    }

  const title = <h2>{group.id ? 'Edit Character' : 'Add Character'}</h2>;

  return (<div>
      <AppNavbar/>
      <Container>
        {title}
        <Form onSubmit={handleSubmit}>
        <DropdownButton
            id="dropdown-basic-button"
            title="Select Class"
            onSelect={handleRoleChange}
            >
              <Dropdown.Item eventKey="Warrior">Warrior</Dropdown.Item>
              <Dropdown.Item eventKey="Wizard">Wizard</Dropdown.Item>
              <Dropdown.Item eventKey="Ranger">Ranger</Dropdown.Item>
        </DropdownButton>
        <h4>You have chosen the {group.id ? group.characterClass: selectedItem} class!</h4>
          <FormGroup>
            <Label for="name">Name</Label>
            <Input type="text" name="name" id="name" value={group.name || ''}
                   onChange={handleChange} autoComplete="name"/>
          </FormGroup>
          <FormGroup>
            <Label for="health">Health</Label>
            <Input type="text" name="health" id="health" value={group.health || ''}
                   onChange={handleChange} autoComplete="health" readOnly/>
          </FormGroup>
          {(selectedItem === "Warrior" || group.characterClass === "Warrior") && (
          <FormGroup>
            <Label for="rage">Rage</Label>
            <Input type="text" name="rage" id="rage" value={group.rage || ''}
                   onChange={handleChange} autoComplete="rage" readOnly/>
          </FormGroup>
          )}
          {(selectedItem === "Wizard" || group.characterClass === "Wizard") && (
          <FormGroup>
            <Label for="mana">Mana</Label>
            <Input type="text" name="mana" id="mana" value={group.mana || ''}
                   onChange={handleChange} autoComplete="mana" readOnly/>
          </FormGroup>
          )}
          {(selectedItem === "Ranger" || group.characterClass === "Ranger") && (
          <FormGroup>
            <Label for="energy">Energy</Label>
            <Input type="text" name="energy" id="energy" value={group.energy || ''}
                   onChange={handleChange} autoComplete="energy" readOnly/>
          </FormGroup>
          )}
          <FormGroup>
            <Button color="primary" type="submit">Save</Button>{' '}
            <Button color="secondary" tag={Link} to="/characters">Cancel</Button>
          </FormGroup>
        </Form>
      </Container>
    </div>
  )
};

export default CharacterEdit;