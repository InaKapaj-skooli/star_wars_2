<?php
   /**
    * @package Star Wars
    */
   /*
   Plugin Name: Star Wars
   Description: Enter a Star Wars ship and find information about it.
   Author: Ina Kapaj
   License: GPLv2 or later
   */

    class Star_Wars_Widget extends WP_Widget{

    protected $formID;
    protected $titleName;
    protected $widgetID;
    protected $TitleFormName;
    protected $widgetPlaceHolder;
    protected $widgetClass;
    protected $widgetHeader;
    protected $searchBarClass;

     public function __construct() {
            parent::__construct(
                'star_wars_widget',
                'Star Wars Ships',
                array( 'description' => 'Get info on Star Wars ships')
            );
            $this->initVariables();
    }

    protected function initVariables(){
        $this->formID = 'title_input';
        $this->titleName = 'title_name';
        $this->widgetID = 'searchBar';
        $this->titleFormName = 'Star Wars Ships';
        $this->widgetPlaceHolder = 'Search';
        $this->widgetClass = 'starWarsWidget';
        $this->widgetHeader ='starWarsWidgetHeader';
        $this->searchBarClass = 'starWarsSearchBar';
    }

    //Front-end display of widget
    public function widget( $args, $instance ) {
        extract( $args );
        $title = $this->TitleFormName;
        $widgetID = $this->get_field_id($this->widgetID);

        echo $before_widget;

        if(isset($instance[$this->titleFormName])){
            $title = $instance[$this->titleFormName];
        }

        echo "<div class='{$this->widgetClass}'>
                <form>
                    <label class='{$this->widgetHeader}' for='{$widgetID}'>{$title} </label>
                    <input id='{$widgetID}' class='{$this->searchBarClass}' placeholder='$this->widgetPlaceHolder' type='search'>
                </form>
            </div>";

        echo $after_widget;
    }

    //Back-end widget form
    public function form( $instance ) {

        if ( isset( $instance[ $this->titleFormName ] ) ) {
            $title = $instance[ $this->titleFormName ];
        }
        else {
            $title = $this->titleFormName;
        }
    ?>
       <p>
        <label for="<?php echo $this->get_field_id( $this->formID ); ?>"><?php echo 'Title:'; ?></label>
        <input class="wide" id="<?php echo $this->get_field_id( $this->formID ); ?>" name="<?php echo $this->get_field_name( $this->titleFormName ); ?>" type="text" value="<?php echo $title; ?>" />
       </p>
    <?php
    }

    public function update( $new_instance, $old_instance ) {
            $instance = array();
            $instance[$this->titleFormName] = ( !empty( $new_instance[$this->titleFormName] ) ) ? strip_tags( $new_instance[$this->titleFormName] ) : '';

            return $instance;
        }
    }

    //array that holds ships
    global $starWarsShips;
        $starWarsShips = [
            'FILENAME' => "ship.json"
        ];


    //-------------------------------------ACTIONS------------------------------------

   //function that shows a dropdown with hints of ships
    function starWarsShipHint() {

        global $starWarsConstants;
        $search_term = stripslashes($_GET['search_term']);
        $url =  plugin_dir_url(dirname(__FILE__)) . 'json/' . $starWarsConstants['FILENAME'];
        $dataSet = null;
        $ships = [];
        $regex = "/" . $search_term . ".+|.+" . $search_term . ".+|.+" . $search_term . "/i" ;
        $returnArray = [];
        $tempArray = [];

        //open the file
        $dataSet = json_decode(file_get_contents($url));

        //build an array of only the ships
        foreach($dataSet as $element){
            array_push($ships,$element->ship);
        }
        //match with regex and return the names that match
        $tempArray = preg_grep($regex,$ships);

        //takes only the values to return, ensures an array is returned and not an object
        foreach($tempArray as $element){
            array_push($returnArray,$element);
        }

        //return the results to javascript client
        echo json_encode($returnArray);

        wp_die();
    }

   //function that gets the submitted ship and find it in json
   function starWarsShipSubmit() {

           global $starWarsShips;
           $url =  plugin_dir_url(dirname(__FILE__)) . 'json/' . $starWarsConstants['FILENAME'];
           $search_term = stripslashes($_GET['search_term']);
           $outputElement = null;
           $dataSet = null;
           $matchFound = false;
           $size = null;

           //open the file
           $dataSet = json_decode(file_get_contents($url));
           //get dataSet size
           $size = count($dataSet);
           //find the searched item, if it exists, get its element, and set the flag
           for($i = 0; $i < $size && !$matchFound;$i++){

               if(!strcasecmp($dataSet[$i]->name,$search_term)){
                   $outputElement = $i;
                   $matchFound = true;
               }
           }

           //return the matched object
           echo json_encode($dataSet[$outputElement]);
           wp_die();
   }
?>