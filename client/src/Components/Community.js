import React, { Component } from 'react';
import Header from './Header';
import { Button, Form, FormGroup, Label, Input } from 'reactstrap';
import './Form.css';

class Community extends Component {
  render() {
    return (
    <div className="Form">
        <Header />
        <div class="form-margin">
            <Form>
                <FormGroup>
                    <Label for="foodLocation">Location</Label>
                    <Input type="location" placeholder="ASU Tempe Campus" />
                </FormGroup>
                <FormGroup>
                    <Label for="foodServings">Servings</Label>
                    <Input type="select" name="select" id="exampleSelect">
                        <option>&#60; 50</option>
                        <option>&#60; 100</option>
                        <option>&#60; 200</option>
                        <option>&#60; 300</option>
                    </Input>
                </FormGroup>
                <FormGroup>
                    <Label for="foodCollectionTime">Time to Collect</Label>
                    <Input type="select" name="select" id="selectFoodCollection">
                        <option>2 hours</option>
                        <option>4 hours</option>
                        <option>12 hours</option>
                        <option>24 hours</option>
                        <option>48 hours</option>
                    </Input>
                </FormGroup>
                <FormGroup>
                    <Label for="foodType">Food Type</Label>
                    <Input type="select" name="select" id="selectFoodType" multiple>
                        <option>Vegan</option>
                        <option>Vegetarian</option>
                        <option>Non-Vegetarian</option>
                        <option>Other</option>
                    </Input>
                </FormGroup>
                <FormGroup>
                    <Button>Submit</Button>
                </FormGroup>
            </Form>   
        </div>
       
    </div>
    );
  }
}

export default Community;