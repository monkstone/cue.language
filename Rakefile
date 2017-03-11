# frozen_string_literal: true

# def create_manifest
#   title = 'Implementation-Title: cue.language'
#   version = '2.0'
#   File.open('MANIFEST.MF', 'w') do |f|
#     f.puts(title)
#     f.puts(version)
#   end
# end

task default: [:compile]

# desc 'Create Manifest'
# task :init do
#   create_manifest
# end

desc 'Compile'
task :compile do
  sh 'mvn package'
end
