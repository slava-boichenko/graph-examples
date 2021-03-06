// CONFIGURATION
// Configures the data loader to create the schema
config dryrun: false, preparation: true, create_schema: true, load_new: true, load_vertex_threads: 3, schema_output: 'loader_output.txt'

// DATA INPUT
// Define the data input source (a file which can be specified via command line arguments)
// inputfiledir is the directory for the input files
inputfiledir = '/graph-examples/documentation-examples/CSV/gzip_test/'
recipeInput = File.csv(inputfiledir +"recipes.csv.gz").gzip().delimiter('|')

//Specifies what data source to load using which mapper (as defined inline)

load(recipeInput).asVertices {
    label "recipe"
    key "name"
    isNew()
}
